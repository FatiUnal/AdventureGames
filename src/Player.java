import java.security.PublicKey;
import java.util.Scanner;
// bu class ta seçtiğimiz oyun karakterinin özellikleri vs var

public class Player {
    private int damage, healty, money, rHealthy; // karakterimizin özellikleri
    private String name, cName;   // cName = Character name
    Inventory inv;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }
    public int getTotalDamage(){
        return this.getDamage() + this.getInv().getDamage();
    }

    public void selectCha() {
        switch (chaMenu()) { // önce chamenu çalıstırılır ve seçilecek karakterler ekrana basılır
            // sonra chaMenuden dönen değer ile karakterin özelliklerini kaydederiz

            //Samuray seçildi
            case 1:
                initPlayer("Samuray", 5, 21, 15);
                break;
            case 2:
                initPlayer("Okcu", 7, 18, 20);
                break;
            case 3:
                initPlayer("Sovalye", 8, 24, 5);
                break;
            default:
                initPlayer("Samuray", 5, 21, 15);
                break;
        }
        System.out.println("Secilen Karakter: " + getcName() + ", Hasar:" + getDamage() + ", Sağlık:" + getHealty() + ", Para:" + getMoney());

    }


    public int chaMenu() {
        System.out.println("lütfen karakter seciniz: ");
        System.out.println("1-Samuray ; Hasar: 5, Sağlık: 21, Para: 15");
        System.out.println("2-Okcu ; Hasar: 7, Sağlık: 18, Para: 20");
        System.out.println("3-Sovalye ; Hasar: 8, Sağlık: 24, Para: 5");
        System.out.print("Karakter Seciminiz: ");
        int chaID = scan.nextInt();

        while (chaID < 1 || chaID > 3) {
            System.out.print("Lütfen geçerli bir karakter giriniz: ");
            chaID = scan.nextInt();

        }
        return chaID;
    }


    public void initPlayer(String cName, int damage, int healty, int money) {
        setcName(cName);
        setDamage(damage);
        setHealty(healty);
        setMoney(money);
        setrHealthy(healty); // ilk canları kayıtlı tutması lazım çünkü güvenli eve gidince sağlık yenilenmesi için max canı bilmemiz lazım
        // seçilen karakteri set methodu ile kaydettik
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
            this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }


    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }


}
