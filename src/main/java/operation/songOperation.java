
package operation;
        import entity.song;

        import java.util.List;
        import java.util.stream.Collectors;

public class  songOperation {


    public static void display(List<song> list)
    {
        list.stream().forEach(c-> System.out.println(c));
    }

    public static  List<song> seacrchByArtist(List<song> list,String name)
    {
        return list.stream().filter(v->v.getArtist().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public static  List<song> seacrchBySong(List<song> list,String name)
    {
        return list.stream().filter(v->v.getTitle().equalsIgnoreCase(name)).collect(Collectors.toList());
    }


    public static  List<song> seacrchByGenere(List<song> list,String name)
    {
        return list.stream().filter(v->v.getGenre().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public static List<song> sort(List<song> list)
    {
        return list.stream().sorted((a,b)->a.getTitle().compareToIgnoreCase(b.getTitle())).collect(Collectors.toList());
    }

}