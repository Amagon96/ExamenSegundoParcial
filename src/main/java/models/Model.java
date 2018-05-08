package models;

public class Model {
    public static String fieldsToInsert(Integer numero){
        String fieldsToInsertAsStr = "";
        for (int i = 0; i < numero; i++) {
            fieldsToInsertAsStr = String.format("%s ?,", fieldsToInsertAsStr);
        }
        return String.format("(%s)", fieldsToInsertAsStr.substring(0, fieldsToInsertAsStr.length()-1));
    }
}
