package WorkingWithAbstraction.Exercise.TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] trafficLights = bf.readLine().split(" ");
        int n = Integer.parseInt(bf.readLine());

        LightsColor[] lights = new LightsColor[trafficLights.length];

        for (int i = 0; i < trafficLights.length; i++) {
            lights[i] = LightsColor.valueOf(trafficLights[i]);
        }
        LightsColor[] lightsColors = {LightsColor.RED, LightsColor.GREEN, LightsColor.YELLOW};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {
                if (lights[j].ordinal() == 2) {
                    lights[j] = LightsColor.RED;
                } else {
                    lights[j] = lightsColors[lights[j].ordinal() + 1];
                }
                System.out.print(lights[j] + " ");
            }
            System.out.println();
        }
    }
}
