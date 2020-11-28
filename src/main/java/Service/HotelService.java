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
        var  vacantHotels = (ArrayList<HotelDTO>)obj.fetchHotels("Berlin", new Date(2020, Calendar.DECEMBER, 24), 1);

        for (HotelDTO dto: vacantHotels) {
            System.out.println(dto.getName());
        }

        return vacantHotels;
    }

    public boolean createBooking() throws RemoteException {
        return obj.createBooking("","");
    }
}
