class RidService {
  public void requestRide(String passenger, String srcLoc, String destLoc) {
    System.out.println("Requesting a ride for passenger: " + passenger +
        " from " + srcLoc + " to " + destLoc);

  }

  public void cancelRide(String passenger) {
    System.out.println("Canceling the ride for passenger: " + passenger);
  }
}

interface Command {
  void execute();
}

class requestCommand implements Command {
  RidService ridService;
  String name;
  String startLocation;
  String destinationLocation;

  requestCommand(RidService ridService, String name, String startLoc, String endLoc) {
    this.ridService = ridService;
    this.name = name;
    this.startLocation = startLoc;
    this.destinationLocation = endLoc;
  }

  public void execute() {
    ridService.requestRide(name, startLocation, destinationLocation);
  }
}

class cancelCommand implements Command {
  String name;
  RidService ridService;

  cancelCommand(RidService ridService, String name) {
    this.name = name;
    this.ridService = ridService;
  }

  public void execute() {
    ridService.cancelRide(name);
  }
}

class RideRequestInvoker {
  public void processRequest(Command command) {
    command.execute();
  }
}

public class Main {

  public static void main(String[] args) {
    RidService rideService = new RidService();
    RideRequestInvoker requestInvoker = new RideRequestInvoker();
    Command Riderequest = new requestCommand(rideService, "Diva", "Mumbai", "Goa");
    Command Riderequest2 = new requestCommand(rideService, "Deep", "Ajmer", "Agra");
    Command CancelRide = new cancelCommand(rideService, "Diva");

    requestInvoker.processRequest(Riderequest);
    requestInvoker.processRequest(Riderequest2);
    requestInvoker.processRequest(CancelRide);

  }

}
