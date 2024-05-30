import java.util.Scanner;
import java.util.Vector;
class staff
{
 private long code;
 private String name;
 private static Vector<staff> all_staff=new Vector<staff>();
 staff(long code,String name)
 {
 this.code=code;
 this.name=name;
 all_staff.add(this);
 }
 static staff findstaff(long cod)
 {
 for (staff accs:all_staff)
 {
 if (accs.code==cod)
 {
 return accs;
 }
 }
 return null;
 }
 long get_code()
 {
 return this.code;
 }
 String get_name()
 {
 return this.name;
 }
}
class teacher extends staff{
 private String subject;
 private int publication;
 teacher(long code,String name,String subject,int publication){
 super(code,name);
 this.subject=subject;
 this.publication=publication;
 }
 String get_sub()
 {
 return this.subject;
 }
 int get_pub()
 {
 return this.publication;
 }
 void print_details()
 {
 System.out.println("code:"+this.get_code()+"\nname:"+this.get_name()+"\nsubject:"+this.subject+"\npublication:"+this.publication);
 }
}
class typist extends staff{
 private double speed;
 typist(long code,String name,double speed){
 super(code,name);
 this.speed=speed;
 }
 double get_speed()
 {
 return this.speed;
 }
}
class officer extends staff{
 private char grade;
 officer(long code,String name,char grade){
 super(code,name);
 this.grade=grade;
 }
 void print_details()
 {
 System.out.println("code:"+this.get_code()+"\nname:"+this.get_name()+"\ngrade:"+this.grade);
 }
}
class regular extends typist
{
 regular(long code,String name,double speed){
 super(code,name,speed);
 }
 void print_details()
 {
 System.out.println("code:"+this.get_code()+"\nname:"+this.get_name()+"\nspeed:"+this.get_speed()+" words per minute");
 }
}
class casual extends typist
{
 private float wages;
 casual(long code,String name,double speed,float wages){
 super(code,name,speed);
 this.wages=wages;
 }
 void print_details()
 {
 System.out.println("code:"+this.get_code()+"\nname:"+this.get_name()+"\nspeed:"+this.get_speed()+" words per minute"+"\nwages:Rs"+this.wages);
 }
}
public class Employee {
 public static void main(String[] args) {
 char cont='y';
 do {
 Scanner menu = new Scanner(System.in);
 int i;
 System.out.println("1 - Add new staff\n2 - Get staff details\n3 - Exit");
 System.out.println("Enter your choice:");
 int choice = menu.nextInt();
switch (choice) {
 case 1:
 Scanner input = new Scanner(System.in);
 System.out.println("Enter staff details:");
 System.out.println("1 - Teacher\n2 - Regular Typist\n3 - Casual Typist\n4 - Officer");
 System.out.println("Enter staff type:");
 int staffType = input.nextInt();
 System.out.println("Enter code:");
 long code = input.nextLong();
 input.nextLine();
 System.out.println("Enter name:");
 String name = input.nextLine();
 switch (staffType) {
 case 1:
 System.out.println("Enter subject:");
 String subject = input.nextLine();
 System.out.println("Enter publication:");
 int publication = input.nextInt();
 teacher newTeacher = new teacher(code, name, subject, publication);
 System.out.println("===============================");
 break;
 case 2:
 System.out.println("Enter speed:");
 double speed = input.nextDouble();
 regular newRegular = new regular(code, name, speed);
 System.out.println("===============================");
 break;
 case 3:
 System.out.println("Enter speed:");
 double casualSpeed = input.nextDouble();
 System.out.println("Enter wages:");
 float wages = input.nextFloat();
 casual newCasual = new casual(code, name, casualSpeed, wages);
 System.out.println("===============================");
 break;
 case 4:
 System.out.println("Enter grade:");
 char grade = input.nextLine().charAt(0);
 officer newOfficer = new officer(code, name, grade);
 System.out.println("===============================");
 break;
 default:
 System.out.println("Invalid staff type.");
 System.out.println("===============================");
 break;
 }
 break;
case 2:
 Scanner scanner = new Scanner(System.in);
 System.out.println("Enter staff code to get details:");
 long searchCode = scanner.nextLong();
 staff foundStaff = staff.findstaff(searchCode);
 if (foundStaff != null) {
 if (foundStaff instanceof teacher) {
 ((teacher) foundStaff).print_details();
 } else if (foundStaff instanceof regular) {
 ((regular) foundStaff).print_details();
 } else if (foundStaff instanceof casual) {
 ((casual) foundStaff).print_details();
 } else if (foundStaff instanceof officer) {
 ((officer) foundStaff).print_details();
 }
 } else {
 System.out.println("Staff with code " + searchCode + " not found.");
 }
 System.out.println("===============================");
 break;
 case 3:
 cont='n';
 return;
 default:
 System.out.println("Invalid choice. Please enter again.");
 System.out.println("===============================");
 }
 }while (cont=='y');
 }
}