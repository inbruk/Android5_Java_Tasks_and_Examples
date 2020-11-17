package android5.lessons.examples;

import java.util.*;

public class MemoryLeakExample {

    // Класс, реализующий циклическую коллекцию
    static class CyclicCollection {
        private final List<byte[]> list = new ArrayList<>(10);

        CyclicCollection() {
            // Займем ~10Mb памяти
            for (int i = 0; i < 10; i++) {
                list.add(new byte[1024 * 1024]);
            }
        }

        Element getElement(int index) {
            // Возвращаем один из десяти элементов, хранящихся
            // в списке. В качестве индекса возьмём
            // остаток от деления на 10. Таким образом внешнему
            // наблюдателю будет казаться, что в коллекции
            // бесконечное количество повторяющихся элементов.
            return new Element(list.get(index % 10));
        }


        // Внутренний класс, хранящий в себе элемент коллекции
        // из-за того что внутренний тащит за собой ссылку на всю коллекцию
        // и она не уничтожается на каждом цикле, поэтому утечка, надо статический
        class Element {
            final byte[] data;

            Element(byte[] data) {
                this.data = data;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.in.read();
        System.out.println("Started !");

        // Список, в котором будем хранить по одному элементу
        // из ста циклических коллекций
        List<CyclicCollection.Element> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            CyclicCollection collection = new CyclicCollection();
            list.add(collection.getElement(i));
            Thread.sleep(500);
        }

        System.out.println("Finished !");
    }
}