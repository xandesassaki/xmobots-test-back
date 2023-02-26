package org.xmobots;

import org.hibernate.Session;
import org.xmobots.DTO.Aerodrome;
import org.xmobots.DTO.AerodromesList;
import org.xmobots.DTO.Runways;
import org.xmobots.utils.HibernateUtils;
import org.xmobots.utils.JsonUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File jsonFile = new File("aerodrome.json");
        String fileName = jsonFile.getAbsolutePath();

        AerodromesList aerodromesList = JsonUtils.readJsonFileForAerodromes(fileName);
        List<Aerodrome> aerodromes = aerodromesList.getAerodromes();

        for(Aerodrome aerodrome : aerodromes) {
            Session session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            List<Runways> runways = aerodrome.getRunway();
            for (Runways runway : runways){
                runway.setAerodrome(aerodrome);
                session.save(runway);
            }
            session.save(aerodrome);
            session.getTransaction().commit();
            session.close();
        }
    }
}