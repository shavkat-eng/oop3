import java.util.*;

// Класс StudyGroup
class StudyGroup {
    private String name;

    public StudyGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Класс Stream, реализующий интерфейс Iterable
class Stream implements Iterable<StudyGroup> {
    private List<StudyGroup> groups;

    public Stream(List<StudyGroup> groups) {
        this.groups = groups;
    }

    public List<StudyGroup> getGroups() {
        return groups;
    }

    @Override
    public Iterator<StudyGroup> iterator() {
        return groups.iterator();
    }
}

// Класс StreamComparator, реализующий интерфейс Comparator
class StreamComparator implements Comparator<Stream> {
    @Override
    public int compare(Stream s1, Stream s2) {
        return Integer.compare(s1.getGroups().size(), s2.getGroups().size());
    }
}

// Класс StreamService
class StreamService {
    public void sortStreams(List<Stream> streams) {
        Collections.sort(streams, new StreamComparator());
    }
}

// Класс Controller
class Controller {
    private StreamService streamService;

    public Controller(StreamService streamService) {
        this.streamService = streamService;
    }

    public void sortStreams(List<Stream> streams) {
        streamService.sortStreams(streams);
    }
}

// Класс Main для тестирования
public class Main {
    public static void main(String[] args) {
        StudyGroup group1 = new StudyGroup("Group1");
        StudyGroup group2 = new StudyGroup("Group2");
        StudyGroup group3 = new StudyGroup("Group3");

        Stream stream1 = new Stream(Arrays.asList(group1, group2));
        Stream stream2 = new Stream(Arrays.asList(group1));
        Stream stream3 = new Stream(Arrays.asList(group1, group2, group3));

        List<Stream> streams = Arrays.asList(stream1, stream2, stream3);

        StreamService streamService = new StreamService();
        Controller controller = new Controller(streamService);

        System.out.println("Before sorting:");
        for (Stream stream : streams) {
            System.out.println("Stream with " + stream.getGroups().size() + " groups.");
        }

        controller.sortStreams(streams);

        System.out.println("After sorting:");
        for (Stream stream : streams) {
            System.out.println("Stream with " + stream.getGroups().size() + " groups.");
        }
    }
}
