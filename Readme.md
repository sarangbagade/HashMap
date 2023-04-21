
Implement HashMap in Java with following


functional requirements 
- key and value can be of any type
- put(key, value)
- get(key)
- remove(key)
- size()

Non-functional requirements
- correctness
- modularity
- extensibility

Implementation :

- keys and values are stored in array of singly linked list
- they are stored in Entry<K, V> class object
- MyHashMap class is generic, accepting 2 type parameters for key(K) and value(V)
- key class should override hashCode and equals methods from Object class
- userful links
  - https://www.baeldung.com/java-hashmap-advanced
  - https://stackoverflow.com/questions/58987907/why-hashmap-resize-when-it-hits-treeify-threshold-value-which-is-not-required
