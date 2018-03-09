package java.JavaBasicTest.EnumClass;

public class EnumClass {
    public static void main(String[] args) {

        System.out.println("Print grades:");
        Grade[] grades = Grade.values();
        for (Grade grade : grades) {
            System.out.print(grade);
            System.out.print("\t");
        }
        System.out.println("\n");


        System.out.println("Print grade's name");
        System.out.println(Grade.C.name());
        System.out.println(Grade.C.getValue());
        System.out.println("\n");


        System.out.println("Print grade's order");
        System.out.println(Grade.C.ordinal());
        System.out.println("\n");


        System.out.println("Convert String to Enum");
        Grade grade = Grade.valueOf("A");
        System.out.println(grade);
        System.out.println("\n");

        System.out.println("Error when Convert String to Enum");
        try {
            grade = Grade.valueOf("T");
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println("\n");


    }
}


// Help to understand Enum class:
// the following two are the same
// "EnumGrade" and "TGrad" (means TraditionalGrade)

enum EnumGrade {
    A("100 - 90"),
    B("89 - 80"),
    C("79 - 70"),
    D("69 - 60"),
    F("59 - 0");

    private String value;

    private EnumGrade(String value) {
        this.value = value;
    }
}

class TGrade {
    private String value;

    private TGrade(String value) {
        this.value = value;
    }

    public static final TGrade A = new TGrade("100 - 90");
    public static final TGrade B = new TGrade("89 - 80");
    public static final TGrade C = new TGrade("79 - 70");
    public static final TGrade D = new TGrade("69 - 60");
    public static final TGrade F = new TGrade("59 - 0");
}



// enum class for testing
enum Grade {
    A("100 - 90"),
    B("89 - 80"),
    C("79 - 70"),
    D("69 - 60"),
    F("59 - 0");

    private String value;

    // modifier 'private' is redundant in enum class
    Grade(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}



// enum class with abstract function
enum Grade2 {
    A("100 - 90") {
        @Override
        String getChineseName() {
            return "优";
        }
    },

    B("89 - 80"){
        @Override
        String getChineseName() {
            return "良";
        }
    },

    C("79 - 70"){
        @Override
        String getChineseName() {
            return "中";
        }
    },

    D("69 - 60"){
        @Override
        String getChineseName() {
            return "及格";
        }
    },

    F("59 - 0"){
        @Override
        String getChineseName() {
            return "不及格";
        }
    };

    private String value;

    // modifier 'private' is redundant in enum class
    Grade2(String value) {
        this.value = value;
    }

    abstract String getChineseName();
}