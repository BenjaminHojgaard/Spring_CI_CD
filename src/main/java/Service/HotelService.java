package Service;

import dto.HotelDTO;
import dto.HotelDetailsDTO;
import org.springframework.stereotype.Service;
import service.HotelUtility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class HotelService {

    String backendURL = "rmi://localhost/HotelService";
    String AWS = "rmi://localhost/hotelserver";
    HotelUtility obj;

    public HotelService() {
        //try {
          //  obj = (HotelUtility) Naming.lookup(AWS);
        //} catch (NotBoundException | MalformedURLException | RemoteException e) {
          //  e.printStackTrace();
        //}
    }

    public ArrayList<HotelDTO> findVacantHotels(String city, Date date, int numOfGuests) throws RemoteException {
       // var hotelsToReturn = (ArrayList<HotelDTO>)obj.fetchHotels("Berlin", new Date(2020, Calendar.DECEMBER, 24), 1);
        //for (HotelDTO dto: hotelsToReturn) {
          //  System.out.println(dto.getName());

        //}

        ArrayList<HotelDTO> hotels =  new ArrayList<>();
        hotels.add(new HotelDTO("Radison", "Radison Street", "berlin"));
        hotels.add(new HotelDTO("Hilton", "Hilton Street", "London"));
        return hotels;
    }

    public boolean createBooking() throws RemoteException {
        return obj.createBooking("","");
    }
}
