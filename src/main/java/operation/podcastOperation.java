package operation;

        import entity.Podcast;

        import java.util.Date;
        import java.util.List;
        import java.util.stream.Collectors;

public class podcastOperation {


    public static void display(List<Podcast> list)
    {
        list.stream().forEach(c-> System.out.println(c));
    }

    public static  List<Podcast> seacrchByCelebrity(List<Podcast> list, String name)
    {
        return list.stream().filter(v->v.getCeleb().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public static  List<Podcast> seacrchByPublishDate(List<Podcast> list, Date date)
    {
        return list.stream().filter(v->v.getDate().equals(date)).collect(Collectors.toList());
    }

    public static List<Podcast> sort(List<Podcast> list)
    {
        return list.stream().sorted((a,b)->a.getNaam().compareToIgnoreCase(b.getNaam())).collect(Collectors.toList());
    }


}
