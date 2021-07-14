package by.konovalchik.company.application.utils;

public class Calculate {
    private static final int R = 6371;

       public static int getDistance (double lat1, double lon1, double lat2, double lon2){
         double d = 0;
         int result;
         d = Math.acos(Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(lon1) - Math.toRadians(lon2)));
         result = (int) (R*d);
        return result ;
    }

}
