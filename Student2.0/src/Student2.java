/**
 * @author 112200338周嘉裕
 * @date 2022/10/27
 */

import java.util.ArrayList;
import java.util.Scanner;

/*学生信息管理系统2.0（重磅升级版）
 *  功能：
 *      1. 录入学生信息（学号，姓名，高数成绩，是否退学）
 *      2. 查看所有学生的信息
 *      3. 查看指定学生的信息
 *      4. 删除指定学生的信息
 *      5. 修改学生信息
 *      6. 查看高数挂科和退学的学生名单
 *      7. 退出系统
 */
public class Student2 {
    //学号
    private String id;
    //姓名
    private String name;
    //高数成绩
    private double grade;
    //是否退学
    private boolean isOff;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean getIsOff() {
        return isOff;
    }

    public void setIsOff(boolean isOff) {
        this.isOff = isOff;
    }

    @Override
    public String toString() {
       // return "学号：" + id + "\t姓名：" + name + "\t高数成绩：" + grade + "\t是否退学：" + isOff;
        return id + "\t\t" + name + "\t\t" + grade + "\t\t" + isOff;
    }

    public Student2(String id, String name, double grade, boolean isOff) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.isOff = isOff;
    }

    private static final Scanner sc = new Scanner(System.in);

    public static void update() {
        sc.useDelimiter("\n");
        System.out.print("请输入学生的学号或姓名：");
        String id = sc.next();
        //标记输入的学号是否存在
        boolean flag1 = true;
        redo:
        for (Student2 stu : list) {
            if (stu.getId().equals(id)||stu.getName().equals(id)) {
                System.out.println("有以下四个项目：1.id, 2.name, 3.grade, 4.isOff，请输入要修改的编号：");
                int option = sc.nextInt();
                System.out.println("请输入修正后的值：");
                switch (option) {
                    case 1:
                        stu.setId(sc.next());
                        System.out.println("修改成功！");
                        break;
                    case 2:
                        stu.setName(sc.next());
                        System.out.println("修改成功！");
                        break;
                    case 3:
                        stu.setGrade(sc.nextDouble());
                        System.out.println("修改成功！");
                        break;
                    case 4:
                        stu.setIsOff(sc.nextBoolean());
                        System.out.println("修改成功！");
                    default :
                            System.out.println("编号输入错误，请重新输入！");
                            continue redo;
                }
                flag1 = false;
                break;
            }
        }
        if (flag1) {
            System.out.println("不存在该学生，请重新输入!");
            update();
        }
    }

    public static void search() {
        sc.useDelimiter("\n");
        System.out.print("请输入学生的学号或姓名：");
        String id = sc.next();
        //标记输入的学号是否存在
        boolean flag = true;
        for (Student2 stu : list) {
            if (stu.getId().equals(id)||stu.getName().equals(id)) {
                flag = false;
                System.out.println("学号\t\t姓名\t高数成绩\t是否退学");
                System.out.println(stu);
                break;
            }
        }
        if (flag) {
            System.out.print("不存在该同学，请重新输入!");
            search();
        }
    }

    public static void unpassedList() {
        boolean flag1 = true, flag2 = true;
        for (Student2 stu : list) {
            if (stu.getGrade() < 60 ) {
                System.out.println("挂科的有以下同学：");
                flag1 = false;
                break;
            }
        }
        if (flag1) {
            System.out.println("所有人都通过了高数考试！");
        } else {
            for (Student2 stu : list) {
                if (stu.getGrade() < 60 ) {
                    System.out.println(stu.getName());
                }
            }
        }
        for (Student2 stu : list) {
            if (stu.isOff) {
                System.out.println("退学的有以下同学：");
                flag2 = false;
                break;
            }
        }
        if (flag2) {
            System.out.println("没有同学退学！");
        } else {
            for (Student2 stu : list) {
                if (stu.isOff) {
                    System.out.println(stu.getName());
                }
            }
        }
    }

    public static void input() {
        sc.useDelimiter("\n");
        while (true) {
            System.out.print("请输入学生的学号：");
            String id = sc.next();
            //定义标记
            boolean flag = false;
            // 判断学号是否已存在
            for (Student2 stu : list) {
                if (stu.getId().equals(id)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("学生信息录入重复，请重新输入！");
                continue;
            }
            System.out.print("请输入学生的姓名：");
            String name = sc.next();
            System.out.print("请输入学生的高数成绩：");
            double grade = sc.nextDouble();
            System.out.print("如果该学生已退学，请输入true，否则输入false：");
            boolean isOff = sc.nextBoolean();
            Student2 student = new Student2(id, name, grade, isOff);
            list.add(student);
            System.out.print("信息录入成功！\n按1继续录入，按其他键停止录入，返回菜单：");
            if (!"1".equals(sc.next())) {
                break;
            }
        }
    }

    public static void display() {
        //显示表头信息
        System.out.println("学号\t\t姓名\t高数成绩\t是否退学");
        for (Student2 student : list) {
            System.out.println(student.toString());
        }
    }

        public static void delete() {
            if(list.size()==0){
                System.out.println("系统暂无学生信息，请先输入信息！");
                input();
            }
            sc.useDelimiter("\n");
            System.out.println("请输入你要删除的学号或姓名：");
            String id=sc.next();
            boolean flag=true;
            for(Student2 stu : list){
                if(stu.getId().equals(id)||stu.getName().equals(id)){
                    flag=false;
                    list.remove(stu);
                    break;
                }
            }
            if(flag){
                System.out.println("不存在该同学，请重新输入！");
                delete();
            }else{
                System.out.println("学生信息删除成功！");
            }
    }
    static ArrayList<Student2> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("-----------欢迎使用学生信息管理系统-----------");
        for (; ; ) {
            System.out.println();
            System.out.println("可操作的选项如下：");
            System.out.println("1.录入学生信息");
            System.out.println("2.查看所有学生的信息");
            System.out.println("3.查看指定学生的信息");
            System.out.println("4.删除学生信息");
            System.out.println("5.修改学生信息");
            System.out.println("6.查看高数挂科和退学的学生名单");
            System.out.println("7.退出系统\n");
            System.out.print("请键入功能编号对学生信息进行管理：");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    input();//录入学生信息
                    break;
                case 2:
                    display();//查看所有学生信息
                    break;
                case 3:
                    search();//根据学生编号查看学生信息
                    break;
                case 4:
                    delete();//删除指定学生信息
                    break;
                case 5:
                    update();//修改学生信息
                    break;
                case 6:
                    unpassedList();//查看高数挂科和退学的学生名单
                case 7:
                    System.exit(0);//退出系统
                default:
                    System.out.print("您输入的编号有误，请重新输入：");
            }
        }
    }
}