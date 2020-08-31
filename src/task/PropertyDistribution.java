package task;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Distribute the given property into two people assume A and B
 */
public class PropertyDistribution {
  
  static PropertyDistribution propertyDistribution;

  //main method
  public static void main(String[] args) {

    propertyDistribution = new PropertyDistribution();

    Map<Integer, Integer> propertyMap = propertyDistribution.preparePropertyMap(); // input

    propertyDistribution.distributePropertiesBetweenAandB(propertyMap); // business logic
  }

  // input method
  private Map<Integer, Integer> preparePropertyMap() {

    // Map is the set of property in terms of key/value pair, key is currency and value is
    // frequency.
    Map<Integer, Integer> propertyMap = new TreeMap<>(Collections.reverseOrder());

    // one can add any currency with any frequency
    propertyMap.put(2000, 3);
    propertyMap.put(1000, 3);
    propertyMap.put(500, 2);
    propertyMap.put(100, 2);

    return propertyMap;
  }

  // business logic
  private void distributePropertiesBetweenAandB(Map<Integer, Integer> propertyMap) {

    int propertySum = sumCalculator(propertyMap);

    Map<Integer, Integer>[] result = calculateFrequencyOfCurrencyDistribution(propertyMap, propertySum / 2);

    validatePropertyDistribution(result);

    printDistributionOfProperty(propertyMap, propertySum, result);
  }

  private void validatePropertyDistribution(Map<Integer, Integer>[] result) {

    int sumOfPropertyOfA = sumCalculator(result[0]);
    int sumOfPropertyOfB = sumCalculator(result[1]);
    
    if (sumOfPropertyOfA != sumOfPropertyOfB) {
      throw new RuntimeException("Can't distribute the property Equally");
    }

  }

  private int sumCalculator(Map<Integer, Integer> propertyMap) {
    int sum = 0;
    // Property calculation
    for (Map.Entry<Integer, Integer> e : propertyMap.entrySet())
      sum += e.getKey() * e.getValue();
    return sum;
  }

  // distribution
  private Map<Integer, Integer>[] calculateFrequencyOfCurrencyDistribution(
      Map<Integer, Integer> propertyMap, int propertyOfA) {

    Map<Integer, Integer> propertyMapOfA = new HashMap<>();
    Map<Integer, Integer> propertyMapOfB = new HashMap<>();
    for (Map.Entry<Integer, Integer> e : propertyMap.entrySet()) {
      int i = 0;
      // iterating till currency limit suitable for A.
      while (i <= e.getValue() && e.getKey() * i <= propertyOfA)
        i++;
      if (i > 0) {
        propertyOfA -= e.getKey() * (i - 1);
        propertyMapOfA.put(e.getKey(), i - 1);
        propertyMapOfB.put(e.getKey(), e.getValue() - (i - 1));
      } else {
        propertyMapOfA.put(e.getKey(), 0);
        propertyMapOfB.put(e.getKey(), e.getValue());
      }
    }
    return new Map[] {propertyMapOfA, propertyMapOfB};
  }

  private void printDistributionOfProperty(Map<Integer, Integer> propertyMap, int sum,
      Map<Integer, Integer>[] result) {

    // decoration
    System.out.println("**************** Property *****************");
    System.out.println(propertyMap + "::: property sum  :" + sum);
    System.out.println("**************** Property of A *****************");
    System.out.println(result[0] + "::: property sum of A:" + sum / 2);
    System.out.println("**************** Property of B *****************");
    System.out.println(result[1] + "::: property sum of B:" + sum / 2);
  }

}
