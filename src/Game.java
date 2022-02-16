import java.util.Scanner;

// bu class oyunun işlemesini sağlıyacak
// yani bu class üzerinden diğer classlara erişim sağlayıp istenileni yaptıracagız

public class Game {
    Player player;   // dışardan nesne alıcaz çünkü player ve location işlem döndükçe
    Location location; // değişkenlerin yeni değerleri kayıtlı tutması lazım
    Scanner scan = new Scanner(System.in);

    public void login(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.print("Oyuna baslamadan önce isminizi giriniz: ");
        String playerName = scan.nextLine();
        player = new Player(playerName);//playerName adında oyuncu olusturulur
        player.selectCha();      // bu method ile seçtiğimiz karakteri setter ile kaydedebildik
        start(); // ile seçilcek karakterleri ekrana bastık
    }

    public void start(){
        while (true){ // gitmek istediğimiz yeri seçeriz ve ona göre belirlenen class lara gönderiliriz
                    // while olmasının sebebi eğer karakter ölmezse tekrar istediği bölgeye gidebilecek

            System.out.println();
            System.out.println("=======================================================");
            System.out.println("Eylem gerçekleştirmek için bir yer seçiniz: ");
            System.out.println("1. Güvenli Ev --> Size ait güvenli mekan,Düsman yok !");
            System.out.println("2. Mağara --> Karşınıza belki zombi çıkabilir !");
            System.out.println("3. Orman --> Karşınıza belki vampr çıkabilir !");
            System.out.println("4. Nehir --> Karşınıza belki ayı çıkabilir !");
            System.out.println("5. Mağaza --> Silah veya Zırh satın alabilirsiniz !");
            System.out.println("Gitmek istediğiniz yer: ");
            int selLoc = scan.nextInt();

            while(selLoc <0 || selLoc>5){
                System.out.println("Lütfen geçerli değer giriniz:");
                selLoc = scan.nextInt();
            }


            switch (selLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;

            }
            if (!location.getLocation()){  // eğer getLocationdan gelen değer false ise bitir
                System.out.println("GAME OVER");
                break;
            }
            if (SafeHouse.counter == 1){
                System.out.println("OYUNU KAZANDINIZ TEBRİKLER");
                break;
            }



        }
    }





}
