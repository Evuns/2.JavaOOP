package interfacesAbstraction.exercise.telephony;

import java.util.List;

public class Smartphone implements  Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String>urls){
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder(this.urls.size());

        String format = "Browsing: %s!";

        for (String url : this.urls) {

            if (url.matches(".*\\d.*")) {
                stringBuilder.append("Invalid URL!");
            } else {
                stringBuilder.append(String.format(format, url));
            }
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder(this.numbers.size());

        String format = "Calling... %s";

        for (String number : this.numbers) {

            if(number.equals(number.replaceAll("[^0-9]", ""))) {
                stringBuilder.append(String.format(format, number));
            } else {
                stringBuilder.append("Invalid number!");
            }
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
