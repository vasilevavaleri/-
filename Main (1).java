import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Предполагается, что у вас есть список зарегистрированных пользователей/администраторов
        String[] users = {"admin:admin123", "user:user123"};
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        
        boolean isAdmin = false;
        for (String user : users) {
            String[] userInfo = user.split(":");
            String username = userInfo[0];
            String userPassword = userInfo[1];
            
            if (login.equals(username) && password.equals(userPassword)) {
                isAdmin = username.equals("admin");
                break;
            }
        }
        
        if (isAdmin) {
            System.out.println("Добро пожаловать, администратор " + login);
            // Здесь можно добавить логику для администратора
        } else {
            System.out.println("Добро пожаловать, пользователь " + login);
            // Здесь можно добавить логику для пользователя
        }
    }
}
