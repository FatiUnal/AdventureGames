// savasın oldugu cave river and forest bölgeleri için ortak bir abs olursutururz.

import java.security.ProtectionDomain;
import java.sql.Time;
import java.util.Locale;

public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;   // hepsinde ortak olarak obstacle oldugu için buraya ekleriz
    protected String award;
    int combatValue = 0;

    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }


    public boolean getLocation() {
        int obsCount = obstacle.count();
        System.out.println("Suan buradasınız: " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor!!");
        System.out.println("<S>avaş veya <K>aç");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("S")) {
            if (combat(obsCount) == true ) {
                System.out.println(this.getName() + " Bölgesindeki Tüm Düşmanları temizlediniz !");
                if (this.award.equals("Food") && player.getInv().isFood() == false) {
                    System.out.println(this.award + " Kazandınız!");
                    player.getInv().setFood(true);

                } else if (this.award.equals("Water") && player.getInv().isWater() == false) {
                    System.out.println(this.award + " Kazandınız!");
                    player.getInv().setWater(true);

                } else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
                    System.out.println(this.award + " Kazandınız!");
                    player.getInv().setFirewood(true);

                }

                return true;
            }else if(combat(obsCount)==false){
                System.out.println("Hiçbir şey kazanamadınız!!");
                return  true;
            } else {
                System.out.println("Öldünüz !");
                return false;
            }

        }
        return true;
    }





    public boolean combat(int obsCount) {
        int defaultobstacleHealth = obstacle.getHealth();
        for (int i = 0; i < obsCount; i++) {
            playerStats();
            System.out.println();
            enemyStats();
            while (player.getrHealthy() > 0 && obstacle.getHealth() > 0) {
                System.out.println("<V>ur yada <K>aç");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")) {
                    System.out.println("Siz vurdunuz !");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    System.out.println(obstacle.getName() + " Canı: " + obstacle.getHealth());
                    System.out.println();
                    if (obstacle.getHealth() > 0) {
                        System.out.println(obstacle.getName() + " size vurdu !");
                        player.setHealty(player.getHealty() - obstacle.getDamage() + player.getInv().getArmor());
                        System.out.println("Sizin Canınız: " + player.getHealty());
                    }

                } else {
                    return false;
                }
            }
            if (obstacle.getHealth() <= 0 && player.getHealty() > 0) {
                System.out.println("Tüm Düşmanları yendiniz");
                player.setMoney(player.getMoney() + obstacle.getAward());

                System.out.println("Güncel paranız: " + player.getMoney());
                obstacle.setHealth(defaultobstacleHealth);
            } else {
                return false;
            }
            System.out.println("====================");

        }
        return true;
    }






    public void playerStats() {
        System.out.println("-------------\nOyuncu değerleri");
        System.out.println("Can: " + player.getHealty());
        System.out.println("Hasar: " + player.getTotalDamage());
        System.out.println("Para: " + player.getMoney());
        if (player.getInv().getDamage() > 0) {
            System.out.println("Silah: " + player.getInv().getwName());
        }
        if (player.getInv().getArmor() > 0) {
            System.out.println("Armor: " + player.getInv().getaName());
        }
    }


    public void enemyStats() {
        System.out.println("------------\n" + obstacle.getName() + " Değerleri");
        System.out.println("Can: " + obstacle.getHealth());
        System.out.println("Hasar: " + obstacle.getDamage());
        System.out.println("Ödül: " + obstacle.getAward());


    }

}
