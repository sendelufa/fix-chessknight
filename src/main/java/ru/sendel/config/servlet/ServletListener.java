package ru.sendel.config.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener {

   @Override
   public void contextInitialized (ServletContextEvent sce) {
      System.out.println("from ServletContextListener: " +
          " context initialized");

   }

   @Override
   public void contextDestroyed (ServletContextEvent sce) {

   }
}
