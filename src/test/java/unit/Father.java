package unit;

import java.lang.reflect.Field;

public abstract class Father {

    public void getPa() throws IllegalAccessException {
        //得到class
        Class cls = this.getClass();
        Father father = this;
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {//遍历
//            try {
            //得到属性
            Field field = fields[i];
            //打开私有访问
            field.setAccessible(true);
            //获取属性
            String name = field.getName();
            System.out.println(name + ":" + field.get(father));
            System.out.printf(name);
//                //获取属性值
//                Object value = field.get(obj);
            //一个个赋值
//                nameVlues += field.getName()+":"+value+",";
             /*catch (IllegalAccessException e) {
                e.printStackTrace();
            }*/
        }
    }

}
