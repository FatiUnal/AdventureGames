public abstract class NormalLoc extends Location{
    // güvenli ve güvensiz 2 tip location oldugu için 2. bir alt abstract olusturduk
    //üstteki location abs sinden kalıtım la özellikleri yine aldık
    // buna artık güvenli bölgelerin istediğimiz ortak özelliğini ekleyebiliriz

    NormalLoc(Player player,String name) {
        super(player);
        this.name = name;
    }


    public boolean getLocation(){
        return true;
    }





}
