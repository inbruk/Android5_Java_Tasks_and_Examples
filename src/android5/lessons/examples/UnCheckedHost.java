package JavaLessons.Task521;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UnCheckedHost {
    public static void main(String[] args) {
        // задание IP-адреса в виде массива
        byte[] ip = { (byte) 217, 69, (byte) 139, (byte) 202 };
        try {
            InetAddress addr = InetAddress.getByAddress(ip);
            System.out.println(addr.getHostName() +
                    "-> соединение:" + addr.isReachable(1000));
        } catch (UnknownHostException e) {
            System.err.println("адрес недоступен " + e);
        } catch (IOException e) {
            System.err.println("ошибка потока " + e);
        }
    }
}