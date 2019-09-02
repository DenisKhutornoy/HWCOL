package textfiles;


public class Text {
    public String text = "Lay beside me and tell me what they've done And speak the words I wanna hear to make my demons run" +
            " The door is locked now but it's open if you're true If you can understand the me then I can understand the you" +
            " Lay beside me, under wicked sky Through black of day, dark of night, we share this, paralyzed The door cracks open but there's no sun shining through" +
            "No there's no sun shining through, no there's no sun shining What I've felt, what I've known Turn the pages, turn the stone Behind the door, should I open it for you" ;



    String[] words = text.toLowerCase().replaceAll("[-.?!)(,:]", "").split("\\s");



    public int findQuantity(String reqword) {
        int qnty = 0;
        for (String word : words) {
            if (word.equals(reqword)){
                qnty=qnty+1;
            }
        }
        return qnty;
    }
}
