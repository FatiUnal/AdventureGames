public class ToolStore extends NormalLoc {
    ToolStore(Player player) {
        super(player, "Mağaza");
    }

    public boolean getLocation() {
        System.out.println("Para: " + player.getMoney());
        System.out.println("1. Silahlar");
        System.out.println("2. Zırhlar");
        System.out.println("3. Çıkış");
        System.out.println("Seçiminiz. ");
        int selTool = scan.nextInt();

        int selItemID; // item seçmek için yaptık
        switch (selTool) {
            case 1:
                buyWeapon(weaponMenu());
                break;
            case 2:
                buyArmor(armorMenu());
            default:
                break;
        }
        return true;
    }

    public void buyArmor(int selItemID){
        int avoid = 0, price = 0;
        String aName = null;
        switch (selItemID) {
            case 1:
                avoid = 1;
                aName = "Hafif Zırh";
                price = 15;
                break;
            case 2:
                avoid = 3;
                aName = "Orta Zırh";
                price = 25;
                break;
            case 3:
                avoid = 5;
                aName = "Ağır Zırh";
                price = 40;
                break;
            case 4:
                System.out.println("Çıkış yapılıyor");
                break;
            default:
                System.out.println("Geçersiz İşlem");
                break;
        }
        if (price>0){
            if (player.getMoney() >= price) {
                player.getInv().setArmor(avoid);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println(aName + " satın aldınız, Engellenen Hasar: " + player.getInv().getArmor());
                System.out.println("Kalan para: " + player.getMoney());
            } else {
                System.out.println("bakiye yetersiz");
            }
        }
    }









    public int armorMenu(){
        System.out.println("1.Hafif Zırh\t<Para: 15  - Hasar:1>");
        System.out.println("2.Orta Zırh\t<Para: 25  - Hasar:3>");
        System.out.println("3.Ağır Zırh\t<Para: 40  - Hasar:5>");
        System.out.println("4. Cıkıs");

        System.out.println("Armor Seçiniz: ");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }


    public void buyWeapon(int selItemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (selItemID) {
            case 1:
                damage = 1;
                wName = "Tabanca";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Kılıç";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Tüfek";
                price = 45;
                break;
            case 4:
                System.out.println("Çıkış yapılıyor");
                break;
            default:
                System.out.println("Geçersiz İşlem");
                break;
        }
        if (price>0){
            if (player.getMoney() > price) {
                player.getInv().setDamage(damage);
                player.getInv().setaName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println(wName + " satın aldınız, Önceki Hasar: " + player.getDamage() + " Yeni Hasar: "
                        + player.getTotalDamage());
                System.out.println("Kalan para: " + player.getMoney());
            } else {
                System.out.println("bakiye yetersiz");
            }
        }


    }


    public int weaponMenu() {
        System.out.println("1.Tabanca\t<Para: 25  - Hasar:2>");
        System.out.println("2.Kılıc\t<Para: 35  - Hasar:3>");
        System.out.println("3.Tufek\t<Para: 45  - Hasar:7>");
        System.out.println("4.Cıkıs");

        System.out.println("Silah Seçiniz: ");
        int selWeaponID = scan.nextInt();
        return selWeaponID;
    }

}
