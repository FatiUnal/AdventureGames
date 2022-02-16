public class SafeHouse extends NormalLoc{
    public static int counter = 0;

    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }


    public boolean getLocation(){
        player.setHealty(player.getrHealthy());
        System.out.println("Sağlığınız fullendi");
        System.out.println("Suan Güvenli Evdesiniz.");
        isThereItems();
        return true;
    }


    public int isThereItems(){
        if (player.getInv().isFirewood() == true && player.getInv().isWater() == true && player.getInv().isFood()== true){
            SafeHouse.counter = 1;
        }
        return SafeHouse.counter;
    }


}
