package rest.techpro.dao;

import java.util.HashMap;
import java.util.Map;

import rest.techpro.model.Techpro;


public enum TechproDao {
    instance;

    private Map<String, Techpro> contentProvider = new HashMap<>();

    private TechproDao() {

        Techpro todo = new Techpro("1", "Prendre un bon petit d�j");
        todo.setDescription("il est important de commencer la journ�e par un repas �quilibr�");
        contentProvider.put("1", todo);
        todo = new Techpro("2", "Faire 10000 pas");
        todo.setDescription("afin de garder une bonne sant�");
        contentProvider.put("2", todo);

    }
    public Map<String, Techpro> getModel(){
        return contentProvider;
    }

}