
public class CollectionString {

    public static MyCollection myCollection;

    public static void main(String[] args) {
        myCollection = new MyCollection(5);
        int ind;
        String str;
        System.out.println(myCollection);

        if (add("Red")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        if (add("Green")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        if (add("Blue")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        if (add("Orange")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        if (add("Black")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        System.out.println("\nМасив до вставки: " + myCollection);
        ind = 1;
        str = "Yellow";
        if (add(ind, str)) System.out.println("Add successfully. Індекс " + ind + " значення: " + str);
        else System.out.println("Add not successfully");
        System.out.println("Масив після вставки: " + myCollection);

        if (add("Gray")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        System.out.println("\nМасив до вставки: " + myCollection);
        ind = 5;
        str = "Add 5";
        if (add(ind, str)) System.out.println("Add successfully. Індекс " + ind + " значення: " + str);
        else System.out.println("Add not successfully");
        System.out.println("Масив після вставки: " + myCollection);

        if (add("RedGreen")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");

        ind = 6;
        if (delete(ind)) {
            System.out.println("\nDelete index " + ind + " successfully");
            System.out.println("Масив після видалення: " + myCollection);
        } else System.out.println("Delete not successfully");

        str = "Red";
        if (delete(str)) {
            System.out.println("\nDelete value " + str + " successfully");
            System.out.println("Масив після видалення: " + myCollection);
        } else System.out.println("Delete not successfully");

        System.out.println(get(3));
        System.out.println(myCollection);
    }

    //1. boolean add(int index, String value);
    public static boolean add(int index, String value) {
        if (index > myCollection.count && myCollection.count != 0) {
            System.out.println("Індекс перевищує максимальний, добавляю слідом за останнім!");
            myCollection.arrayStr[myCollection.count] = value;
            myCollection.count++;
            return true;
        }
        //Якщо список пустий додаємо з індексом 0
        if (myCollection.count == 0) {
            System.out.println("Масив пустий, добавляю з індексом 0!");
            myCollection.arrayStr[0] = value;
            myCollection.count++;
            return true;
        }
        if ((myCollection.count) == myCollection.arrayStr.length) {
            //Підготувати новий масив, переписати в нього все з першого
            myCollection.arrayStr = createCopyFieldsOfArray(myCollection.arrayStr);
        }
        //Скопіювали
        for (int i = myCollection.count; i > index; i--) {
            myCollection.arrayStr[i] = myCollection.arrayStr[i - 1];
        }
        //записали з індексом
        myCollection.arrayStr[index] = value;
        myCollection.count++;
        return true;
    }

    //2. boolean add(String value);
    public static boolean add(String value) {
        //Якщо список пустий додаємо з індексом 0
        if (myCollection.count == 0) {
            myCollection.arrayStr[0] = value;
            myCollection.count++;
            System.out.println("\nЗначення " + value + " добавлено під індексом " + (myCollection.count - 1));
            return true;
        }
        while (myCollection.count < myCollection.arrayStr.length) {
            myCollection.arrayStr[myCollection.count] = value;
            myCollection.count++;
            System.out.println("\nЗначення " + value + " добавлено під індексом " + (myCollection.count - 1));
            return true;
        }
        if (myCollection.count == myCollection.arrayStr.length) {
            //Підготувати новий масив, переписати в нього все з першого
            myCollection.arrayStr = createCopyFieldsOfArray(myCollection.arrayStr);
        }
        //продовжувати записувати
        myCollection.arrayStr[myCollection.count] = value;
        myCollection.count++;
        System.out.println("\nЗначення " + value + " добавлено під індексом " + (myCollection.count - 1));
        return true;
    }

    //3. boolean delete(int index);
    public static boolean delete(int index) {
        if ((index > myCollection.count) || (index < 0)) {
            System.out.println("\nІндекс " + index + " виходить за границі. Максимальний індекс не null " +
                    (myCollection.count - 1));
            return false;
        }
        //Скопіювали
        for (int i = index; i < myCollection.count; i++) {
            myCollection.arrayStr[i] = myCollection.arrayStr[i + 1];
        }
        myCollection.count--;
        return true;
    }

    //4. boolean delete(String value);
    public static boolean delete(String value) {
        int index = -1;
        for (int i = 0; i < myCollection.count; i++) {
            if (myCollection.arrayStr[i].equalsIgnoreCase(value)) {
                index = i;
            }
        }
        if (index == -1) return false;
            //Скопіювали
        else {
            for (int i = index; i < myCollection.count; i++)
                myCollection.arrayStr[i] = myCollection.arrayStr[i + 1];
            myCollection.count--;
            return true;
        }
    }

    //5. String get(int index);
    public static String get(int index) {
        String s;
        if ((index < myCollection.count) && (index >= 0))
            s = "\nЕлемент масиву з індексом " + index + " є: " + myCollection.arrayStr[index];
        else s = "\nІндекс " + index + " виходить за границі. Максимальний індекс не null " +
                (myCollection.count - 1);
        return s;
    }

    //    новий масив на 5 елементів більше
    private static String[] createCopyFieldsOfArray(String[] source) {
        String[] temp = new String[source.length + 5];
        System.arraycopy(source, 0, temp, 0, source.length);
        return temp;
    }

}

