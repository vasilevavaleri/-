import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface SalonView {
  void displayClients(List<Client> clients);
  void displayServices(List<Service> services);
  void displayBookings(List<Booking> bookings);
  Client getClientData();
  Service getServiceData();
  String getBookingDate();
  void displayBookingConfirmation(String message);
}

// Model
class SalonModel {
  private List<Client> clients;
  private List<Service> services;
  private List<Booking> bookings;

  public SalonModel() {
    clients = new ArrayList<>();
    services = new ArrayList<>();
    bookings = new ArrayList<>();
  }

  public List<Client> getClients() {
    return clients;
  }

  public List<Service> getServices() {
    return services;
  }

  public List<Booking> getBookings() {
    return bookings;
  }

  public void addClient(Client client) {
    clients.add(client);
  }

  public void addService(Service service) {
    services.add(service);
  }

  public void addBooking(Booking booking) {
    bookings.add(booking);
  }
}

// Presenter
class SalonPresenter {
  private SalonModel model;
  private SalonView view;

  public SalonPresenter(SalonModel model, SalonView view) {
    this.model = model;
    this.view = view;
  }

  public void init() {
    view.displayClients(model.getClients());
    view.displayServices(model.getServices());
    view.displayBookings(model.getBookings());

    Client client = view.getClientData();
    model.addClient(client);

    Service service = view.getServiceData();
    model.addService(service);

    String bookingDate = view.getBookingDate();
    Booking booking = new Booking(client, service, bookingDate);
    model.addBooking(booking);

    view.displayBookingConfirmation("Booking added successfully!");
    view.displayBookings(model.getBookings());
  }
}

// Model Classes
class Client {
  private String name;
  private String phone;

  public Client(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }
}

class Service {
  private String name;
  private double price;

  public Service(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }
}

class Booking {
  private Client client;
  private Service service;
  private String date;

  public Booking(Client client, Service service, String date) {
    this.client = client;
    this.service = service;
    this.date = date;
  }

  public Client getClient() {
    return client;
  }

  public Service getService() {
    return service;
  }

  public String getDate() {
    return date;
  }
}

// Console View Implementation
class ConsoleView implements SalonView {
  private Scanner scanner;

  public ConsoleView() {
    scanner = new Scanner(System.in);
  }

  @Override
  public void displayClients(List<Client> clients) {
    System.out.println("---- Clients ----");
    for (Client client : clients) {
      System.out.println("Name: " + client.getName() + ", Phone: " + client.getPhone());
    }
    System.out.println();
  }

  @Override
  public void displayServices(List<Service> services) {
    System.out.println("---- Services ----");
    for (Service service : services) {
      System.out.println("Name: " + service.getName() + ", Price: " + service.getPrice());
    }
    System.out.println();
  }

  @Override
  public void displayBookings(List<Booking> bookings) {
    System.out.println("---- Bookings ----");
    for (Booking booking : bookings) {
      System.out.println("Client: " + booking.getClient().getName() + ", Service: " + booking.getService().getName() + ", Date: " + booking.getDate());
    }
    System.out.println();
  }

  @Override
  public Client getClientData() {
    System.out.println("Enter client name:");
    String name = scanner.nextLine();
    System.out.println("Enter client phone:");
    String phone = scanner.nextLine();
    return new Client(name, phone);
  }

  @Override
  public Service getServiceData() {
    System.out.println("Enter service name:");
    String name = scanner.nextLine();
    System.out.println("Enter service price:");
    double price = Double.parseDouble(scanner.nextLine());
    return new Service(name, price);
  }

  @Override
  public String getBookingDate() {
    System.out.println("Enter booking date:");
    return scanner.nextLine();
  }

  @Override
  public void displayBookingConfirmation(String message) {
    System.out.println("Booking Confirmation: " + message);
    System.out.println();
  }
}

// Main Class
public class Main {
  public static void main(String[] args) {
    SalonModel model = new SalonModel();
    SalonView view = new ConsoleView();
    SalonPresenter presenter = new SalonPresenter(model, view);
    presenter.init();
  }
}
      
