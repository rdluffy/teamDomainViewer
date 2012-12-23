package org.kaizoku;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Person> users;
    private List<Project> projects;
    private List<Domain> domains;

    public Main() {
        domains = new ArrayList<Domain>();
        projects = new ArrayList<Project>();
        users = new ArrayList<Person>();

        Project gamification = new Project("gamification", "description");

        users.add(new Person("npelloux"));
        users.add(new Person("scauch"));
        users.add(new Person("jLeclert"));
    }

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv("PORT"));

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new HttpHandler() {
            final Main main = new Main();

            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String body = "";

                if ("/update".equals(exchange.getRequestURI().getPath())) {
                   // main.updateQuality();
                } else {
                    body = itemsAsJson();

                    String query = exchange.getRequestURI().getQuery();
                    if (null != query) {
                        String callback = query.split("[&=]")[1];
                        body = callback + "(" + body + ")";
                    }
                }

                byte[] response = body.getBytes();
                exchange.sendResponseHeaders(200, response.length);
                exchange.getResponseBody().write(response);
                exchange.close();
            }

            private String itemsAsJson() {
                List<String> json = Lists.newArrayList();
                for (Person person : main.getUsers()) {
                    json.add(String.format("{\"name\":\"%s\"}", person.getName()));
                }
                return "[" + Joiner.on(",").join(json) + "]";
            }
        });
        server.start();

    }

    public List<Person> getUsers() {
        return users;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }
}
