import java.util.*;

class Student {
    private String id, name;
    private int marks;

    public Student(String id, String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId(){
        return id;
    }
    public int getMarks(){
        return marks;
    }
    public String getRole(){
        return "Undergrad";
    }

    @Override
    public String toString(){
        return id + "-" + name + " (" + marks + ") " + getRole();
    }
}

class GraduateStudent extends Student {
    private String area;

    public GraduateStudent(String id, String name, int marks, String area){
        super(id, name, marks);
        this.area = area;
    }

    @Override
    public String getRole(){
        return "Grad (" + area + ")";
    }
}
class HonourStudent extends Student{
    private int bonous_marks;
    public HonourStudent(String id,String name,int marks,int bonous_marks){
        super(id,name,marks);
        this.bonous_marks=bonous_marks;
    }
    @Override
    public int getMarks(){
        return super.getMarks()+bonous_marks;
    }
    @Override
    public String getRole(){
        return "HONOUR";
    }
    
}

class Repository<T> {
    private Map<String, T> data = new HashMap<>();

    public void save(String id, T obj){ data.put(id, obj); }
    public T find(String id){ return data.get(id); }
    public void delete(String id){ data.remove(id); }
}

public class Main {
    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("S1", "Yash", 80));
        list.add(new Student("S2", "Sourav", 78));
        list.add(new Student("S3", "Aman", 90));
        list.add(new Student("S4", "Ayush", 90));

        list.add(new GraduateStudent("G1", "OMPRAKASH", 85, "Artificial Intelligence"));
        list.add(new HonourStudent("H1","PREAM",95,55));

        Repository<Student> repo = new Repository<>();
        for(Student s : list) repo.save(s.getId(), s);

        System.out.println("ALL:");
        list.forEach(System.out::println);

        System.out.println("\nLOOKUP S2:");
        Student s = repo.find("S2");
        System.out.println(s != null ? s : "not found");

        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student st = it.next();

            if(st.getMarks() < 80){
                it.remove();
                repo.delete(st.getId());
            }
        }

        System.out.println("\nAFTER REMOVAL:");
        list.forEach(System.out::println);
        
     int max_marks = 0;
        for (Student st : list)
            max_marks = Math.max(max_marks, st.getMarks());

        System.out.println("\nTopper(s):");
        for (Student st : list)
            if (st.getMarks() == max_marks)
                System.out.println(st.getId() + ": " + st);
    }

}
