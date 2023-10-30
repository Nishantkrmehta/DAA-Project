import java.util.*;

public class ChromaticHarmony {
    public static Map<Character, Integer> colorGraph(Map<Character, List<Character>> graph) {
        Map<Character, Integer> colors = new HashMap<>();
        Set<Integer> usedColors = new HashSet<>();

        for (Character node : graph.keySet()) {
            usedColors.clear();

            for (Character neighbor : graph.get(node)) {
                if (colors.containsKey(neighbor)) {
                    usedColors.add(colors.get(neighbor));
                }
            }

            int color = 1;
            while (usedColors.contains(color)) {
                color++;
            }

            colors.put(node, color);
        }

        return colors;
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('A', 'C', 'D'));
        graph.put('C', Arrays.asList('A', 'B', 'D'));
        graph.put('D', Arrays.asList('B', 'C'));

        Map<Character, Integer> coloring = colorGraph(graph);
        int numColors = Collections.max(coloring.values());

        System.out.println("Minimum number of colors required: " + numColors);
        System.out.println("Node colors: " + coloring);
    }
}
