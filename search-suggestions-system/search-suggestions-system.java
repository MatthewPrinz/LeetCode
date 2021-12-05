class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TreeMap<String, Integer> productToIndex = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);
        for (int i = 0; i < products.length; i++) {
            productToIndex.put(products[i], i);
        }
        String key = "";
        for (int i = 0; i < searchWord.length(); i++) {
            key += searchWord.charAt(i);
            String ceiling = productToIndex.ceilingKey(key);
            String floor = productToIndex.floorKey(key + "~");
            if (ceiling == null || floor == null)
                break;
            result.add(productsList.subList(productToIndex.get(ceiling), Math.min(productToIndex.get(ceiling) + 3, productToIndex.get(floor) + 1)));
        }
        while (result.size() < searchWord.length())
            result.add(new ArrayList<>());
        return result;
    }
}