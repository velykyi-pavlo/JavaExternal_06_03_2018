package com.velykyi.controller;


import com.velykyi.model.Coordinates;
import com.velykyi.model.impl.*;
import com.velykyi.model.util.SearchUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GetIndexPageServlet extends HttpServlet {

    private final static String index = "/WEB-INF/view/index.jsp";

    private List<Vehicle> vehicles;
    private List<Vehicle> vehiclesCurent;

    @Override
    public void init() throws ServletException {
        vehicles = new CopyOnWriteArrayList<Vehicle>(){
            {
                add(new Car(1000, 100, 2005, new Coordinates(2, 3)));
                add(new BetMobile(3000, 300, 2010, new Coordinates(2, 3)));
                add(new Ship(5000, 200, 2012, new Coordinates(2, 3), 35, "adress"));
                add(new Plane(4500, 900, 2007, new Coordinates(2, 3), 45, 23));
                add(new Amfibia(2000, 150, 2015, new Coordinates(2, 3)));

            }
        };
         vehiclesCurent = new ArrayList<>(vehicles);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("vehicles", vehiclesCurent);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");


        final String typeVehicle = req.getParameter("type");
        final String priceFrom = req.getParameter("priceFrom");
        final String priceTo = req.getParameter("priceTo");
        final String ageFrom = req.getParameter("ageFrom");
        final String ageTo = req.getParameter("ageTo");
        final String sped = req.getParameter("speed");


        SearchUtils searchLst = new SearchUtils();
        searchLst.setList(vehicles);

        searchLst.getListVechicleByType(typeVehicle);

        if (priceFrom != null && priceFrom.length() > 0
                && priceTo != null && priceTo.length() > 0)

            searchLst.getVechicleByPrice(Integer.parseInt(priceFrom), Integer.parseInt(priceTo));

        if (ageFrom != null && ageFrom.length() > 0
                && ageTo != null && ageTo.length() > 0)

            searchLst.getListVechicleByYears(Integer.parseInt(ageFrom), Integer.parseInt(ageTo));

        if (sped != null && sped.length() > 0)
            searchLst.getVechicleBySpeed(Integer.parseInt(sped));

        vehiclesCurent = searchLst.getList();

        doGet(req, resp);
    }


}
