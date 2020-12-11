package by.day8;

public class Task {
    public static void main(String[] args) {

        Airplane airplane1 = new Airplane("SSR", 2019, 200, 70000);
        Airplane airplane2 = new Airplane("DDW", 2015, 250, 100000);
        Airplane.compareAirplanes(airplane1, airplane2);
//String str =new String();
//
//for (int i=0;i<20000;i++ ){
//
//    str += " "+ i;
//}
//        System.out.println(str);

//StringBuilder sb =new StringBuilder();
//        for (int i=0;i<20000;i++ ) {
//            sb.append(" "+i);
//        }
//        System.out.println(sb);
        System.out.println(airplane1);
    }
}
