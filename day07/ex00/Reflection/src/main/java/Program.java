import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {

        System.out.println("Classes:\n  - User\n  - Car\n---------------------\nEnter class name:");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();

        className = "Classes." + className;

        Class aClass = null;
        try {
            aClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Field fields[] = aClass.getDeclaredFields();

        System.out.println("---------------------\nfields:");

        String type = null;

        for (Field field : fields) {
            type = String.valueOf(field.getType());
            if (type.equals("class java.lang.String"))
                System.out.println("       String " + field.getName());
            else
                System.out.println("       " + field.getType() + " " + field.getName());
        }
        System.out.println("methods:");

        Method methods[] = aClass.getDeclaredMethods();

        for (Method method : methods){
            if (!method.getName().equals("toString"))
                System.out.println("       " + method.getReturnType() + " "+ method.getName()
                +"(" + Arrays.toString(method.getParameterTypes()) + ")");
        }

        System.out.println("---------------------\nLet’s create an object.");

        Class types[] = new Class[fields.length];

        for (int i = 0; i < types.length; i++) {
            types[i] = fields[i].getType();
        }

        Constructor constructor = null;
        try {
            constructor = aClass.getDeclaredConstructor(types);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Integer intValue = 0;
        String stringValue = "";
        Object arguments[] = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            System.out.println(fields[i].getName() + ":");
            if (types[i].getName().equals("int")) {
                try{
                    intValue = scanner.nextInt();
                }
                catch (Exception e){
                    System.out.println("Wrong input");
                    System.exit(0);
                }
                arguments[i] = intValue;
            } else if (types[i].getName().equals("java.lang.String")) {
                try{
                    stringValue = scanner.next();
                }
                catch (Exception e){
                    System.out.println("Wrong input");
                    System.exit(0);
                }
                arguments[i] = stringValue;
            }
        }
        Object object = null;
        try {
            object = constructor.newInstance(arguments);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Object created: " + object);
        System.out.println("---------------------\nEnter name of the field for changing:");

        String nameField = null;
        try {
            nameField = scanner.next();
        }
        catch (Exception e){
            System.out.println("Wrong field name");
            System.exit(0);
        }

        int j = 0;
        for (Field field : fields) {
            if (field.getName().equals(nameField)) {
                type = String.valueOf(field.getType());
                break;
            }
            j++;
        }
        if (j == types.length){
            System.out.println("Wrong field");
            System.exit(0);
        }

        if (type.equals("class java.lang.String"))
            type = "String";
        System.out.println("Enter " + type + " value:");

        Field privateField = object.getClass().getDeclaredField(nameField);
        privateField.setAccessible(true);

        if (type.equals("int")) {
            try {
                intValue = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("Wrong type data");
                System.exit(0);
            }

            privateField.set(object, intValue);
        } else if (type.equals("String")) {
            try {
                stringValue = scanner.next();
            }
            catch (Exception e){
                System.out.println("Wrong type data");
                System.exit(0);
            }
            privateField.set(object, stringValue);
        }
        System.out.println("Object updated: " + object);

        System.out.println("---------------------\nEnter name of the method for call:");

        String nameMethod = null;
        try {
            nameMethod = scanner.next();
        }
        catch (Exception e){
            System.out.println("Wrong method name");
            System.exit(0);
        }

        Method newMethod = null;
        for (Method method : methods){
            if (method.getName().equals(nameMethod))
                newMethod = method;
        }
        if (newMethod == null){
            System.out.println("Wrong method name");
            System.exit(0);
        }
        System.out.println("Enter " + newMethod.getParameterTypes()[0] + " value");
        int arg = 0;
        try {
            arg = scanner.nextInt();
        }
        catch (Exception e){
            System.out.println("Wrong value");
            System.exit(0);
        }

        Class returnType = newMethod.getReturnType();

        if (returnType.getTypeName().equals("void")){
            System.exit(0);
        }

        System.out.println("Method returned:\n" + newMethod.invoke(object, arg).toString());
    }
}

