package HW06;
import java.util.ArrayList;
import javax.swing.JOptionPane;
// Создал класс DataBase
class DataBase{
    // Создал объектную переменную films, которая ссылается на 
    // на объект new ArrayList
    ArrayList<Cinema> Films = new ArrayList<>();
    ArrayList<FilmProducer> Prod = new ArrayList<>();
    ArrayList<Genre> Genres = new ArrayList<>();

    //Описываю метод, который будет добовлять в объектную
    // переменную Prod, значения объекта создоваемого в классе
    // FilmProducerFactory
    public void addFilmProducer(FilmProducer producer){
        Prod.add(producer);
    }
}
// Описываю класс Cinema
class Cinema{
    // Создаю поля класса Cinema
    int id;
    String name;
    int filmProd;
    int genre;
    //Создаю конструктор для класса Cinema
    Cinema(int id, String name, int filmProd, int genre){
        // Присваиваю полям класса Cinema, значения аргументов конструктора
        this.id = id;
        this.name = name;
        this.filmProd = filmProd;
        this.genre = genre;

    }
}
// Описываю класс FilmProducer
class FilmProducer{
    // Создаю поля класса FilmProducer
    int id;
    String titleName;
}
//Описываю класс Genre
class Genre{
    //Создаю поля класса Genre
    int id;
    String genreName;
    Genre(int id, String genreName){
        this.id = id;
        this.genreName = genreName;
    }
}
// Описываю класс Infrastructure
class Infrastructure{
    //Создаю конструктор
    public Infrastructure(){
        init();
    }
    // Создаю объектную переменную класса Database
    DataBase Db;
    //описываю метод получения Db
    public DataBase getDb(){
        return Db;
    }
    public String getAllInfo(int idCinema){
        
        Cinema c = Db.Films.get(idCinema-1);
    return String.format("%d,%s,%s,%s",c.id, c.name, Db.Prod.get(c.filmProd-1).titleName, Db.Genres.get(c.genre-1).genreName);
    }
    public ArrayList<String> findFilm(String userText){
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        String lower;
        while(i < Db.Films.size()){
            lower = Db.Films.get(i).name;
            lower = lower.toLowerCase();
            userText = userText.toLowerCase();
            if(lower.startsWith(userText)){
                result.add(Db.Films.get(i).name);
            }
            i++;


        }
        return result;
    }
    //Описвыаю метод класса Infrastructure
    DataBase init(){
        //Присваиваю объектной переменой Db ссылку к объекту new DataBase
        Db = new DataBase();
        //Создаю объектную переменную класса Cinema
        Cinema C1 = new Cinema(1,"Ironman",1,1);
        Cinema C2 = new Cinema(2,"Ironwoman",2,2);
        Cinema C3 = new Cinema(3,"Spiderman",3,1);
        Cinema C4 = new Cinema(4,"Spiderwoman",4,2);
        //Присвоил объекту Films, который является объектом класса DataBase
        //значения объекта C1 
        Db.Films.add(C1);
        Db.Films.add(C2);
        Db.Films.add(C3);
        Db.Films.add(C4);
        //Присвоил объекту Genres, который является объектом класса DataBase
        // значение конструктора new Genre. Здесь я обошелся без объектной переменной
        Db.Genres.add(new Genre(1, "Action"));
        Db.Genres.add(new Genre(2, "Comedy"));
        //Присвоил объекту Prod, который является объектом класса DataBase
        // через метод addFilmProducer, у которого аргументом является объект
        // класса FilmProducer(Объект класса FilmProducer получаем через метод getFilmProducer. Метод getFilmProducer
        // является мотодом класса FilmProducerFactory)
        Db.addFilmProducer(FilmProducerFactory.getFilmProducer("Marvel"));
        Db.addFilmProducer(FilmProducerFactory.getFilmProducer("Marvel"));
        Db.addFilmProducer(FilmProducerFactory.getFilmProducer("DC"));
        Db.addFilmProducer(FilmProducerFactory.getFilmProducer("DC"));

    return Db;    
    }

}
//Описываю класс FilmProducerFactory
class FilmProducerFactory{
    //Создаю статическое поле типа int
    static int count = 1;
    //Описываю метод, который будет создавать объекты FilmProducer класса FilmProducer
    static FilmProducer getFilmProducer(String name){
        FilmProducer fp = new FilmProducer();
        fp.id = count++;
        fp.titleName = name;
    return fp;    
    }

}
class ShowArrayList{
    static void show(ArrayList<String> a){
        String tex = "";
        int count = 1;
        for(String data : a){

            tex+=count+"."+data+" ";
            count++;
        }
        JOptionPane.showMessageDialog(null, tex, "Результат поиска", JOptionPane.INFORMATION_MESSAGE);


    }
} 
public class hw06 {
    public static void main(String[] args) {
        //Создаю объектную переменую infrastructure
        Infrastructure infrastructure = new Infrastructure();
        ArrayList<String> show = new ArrayList<>();
        String example = JOptionPane.showInputDialog(null, "Введите название фильма:", "Окно поиска",JOptionPane.QUESTION_MESSAGE);
        show = infrastructure.findFilm(example);
        // System.out.println(show.get(0));
        // System.out.println(show.get(1));
        ShowArrayList.show(show);
        // System.out.println(infrastructure.getAllInfo(1));
        // System.out.println(infrastructure.getAllInfo(2));
        // System.out.println(infrastructure.getAllInfo(3));
        // System.out.println(infrastructure.getAllInfo(4));
        System.exit(0);
    }

    
}
