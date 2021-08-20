package com.company;

import java.io.*;
import java.util.*;


public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {

        // THIS IS FOR WRITING THE LOCATIONS IN THE FILE
        try(ObjectOutputStream locfile=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))){
            for(Location location : locations.values()){
                locfile.writeObject(location);
            }
        }
        catch (IOException e){
            e.getMessage();

        }






//        try(DataOutputStream locfile=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))){
//            for(Location location : locations.values()){
//                locfile.writeInt(location.getLocationID());
//                locfile.writeUTF(location.getDescription());
//                locfile.writeInt(location.getExits().size()-1);
//                for(String direction : location.getExits().keySet()){
//                    if(!direction.equalsIgnoreCase("Q")) {
//                `        locfile.writeUTF(direction);
//                        locfile.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }
//        }catch (IOException e){
//            e.getMessage();
//        }

    }

    static {
        //THIS READS FROM  THE  FILE AND LOADS THE DATA ON THE RUNNING LOCATION CLASS
        try(ObjectInputStream stream=new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
            while (true){
                Location location;
                location=(Location) stream.readObject();
                locations.put(location.getLocationID(),location);
            }
        }catch (IOException e ){
            e.getMessage();
        }catch ( ClassNotFoundException exception){
            exception.getMessage();
        }







//        try(DataInputStream stream=new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
//            Location location;
//            Map<String,Integer> exits=new HashMap<>();
//            while(true) {
//                int locId = stream.readInt();
//                String description = stream.readUTF();
//                int exitNumber = stream.readInt();
//                for (int i = 0; i < exitNumber; i++) {
//                    String direction = stream.readUTF();
//                    int destination = stream.readInt();
//                    exits.put(direction, destination);
//                }
//                locations.put(locId,new Location(locId,description,exits));
//            }
//        }catch(IOException e){
//            e.getMessage();
//        }












//        try(Scanner scanner = new Scanner(new FileReader("locations_big.txt"))
//        ) {
//            Location location;
//            scanner.useDelimiter(",");
//            while (scanner.hasNext()){
//                Map<String,Integer> exits=new HashMap<>();
//                int locationID = scanner.nextInt();
//                System.out.println("the location Id :-"+locationID);
//            scanner.skip(scanner.delimiter());
//            String description = scanner.nextLine();
//                System.out.println("the description of the location"+locationID+" is :- "+description);
//
//                location=new Location(locationID,description,exits);
//                locations.put(location.getLocationID(),location);
//        }
//        }catch (IOException e){
//            e.getMessage();
//        }
//
//        try(Scanner dirScanner =new Scanner(new FileReader("directions_big.txt"))){
//            while(dirScanner.hasNext()){
//                String[] stringArray=dirScanner.nextLine().split(",");
//
//                int locId=Integer.parseInt(stringArray[0]);
//
//                locations.get(locId).addExit(stringArray[1],Integer.parseInt(stringArray[2]));
//            }
//
//        }catch(IOException e){
//            e.getMessage();
//        }













//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest",tempExit));

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
