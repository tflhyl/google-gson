# google-gson

Fork from https://code.google.com/p/google-gson

> Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.


## Nested json support

You can use `@NestedName` annotation to 'flatten' simple nested JSON object and map it to corresponding attribute of the target class.

For example let's say we have this JSON:
```javascript
{
  id: 2608,
  name: "Beef Burger",
  counts: {
    likes: 14,
    comments: 11,
  }
}
```
Normally you would need to write custom deserializer or create a Counts object capture the likes and comments. With `@NestedName` you can now instead do this:
```java
public class Food {
  @SerializedName("id")
  public final long id;

  @SerializedName("name")
  private String name;

  @NestedName(parent = "counts", value = "likes")
  private int likesCount;

  @NestedName(parent = "counts", value = "comments")
  private int commentsCount;
}
```
