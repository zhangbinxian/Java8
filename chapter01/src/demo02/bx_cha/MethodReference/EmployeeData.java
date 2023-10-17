package demo02.bx_cha.MethodReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bx_cha
 * @version 1.0
 * 员工数据
 */
public class EmployeeData {
    public static List<Employee> getEmployee(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"zbx",20,2000));
        list.add(new Employee(1002,"abc",30,3000));
        list.add(new Employee(1003,"def",23,5100));
        list.add(new Employee(1004,"wxy",25,2000));
        list.add(new Employee(1005,"ljjg",19,4000));
        list.add(new Employee(1006,"wdc",31,3000));
        list.add(new Employee(1007,"lxla",55,2500));
        list.add(new Employee(1008,"wlll",30,2100));


        return  list;
    }
}
