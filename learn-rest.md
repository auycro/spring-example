## Learn Rest

https://restfulapi.net/

#### Principle

- Client–server
- Stateless
- Cacheable
- Uniform interface
- Layered system
- Code on demand (optional) 

#### REST naming guide

https://restfulapi.net/resource-naming/

- Use nouns to represent resources
- resource archetypes
    - document
        - Use “singular” name to denote document resource archetype
        
        ```
        http://api.example.com/user-management/users/admin
        ```
    
    - collection
        - Use the “plural” name to denote the collection resource archetype.
        
        ```
        http://api.example.com/song-management/users/{id}/playlists
        ```
    
    - store
        - Use “plural” name to denote store resource archetype.

        ```
        http://api.example.com/song-management/users/{id}/playlists
        ```
    
    - controller
        - Use “verb” to denote controller archetype.

        ```
        http://api.example.com/cart-management/users/{id}/cart/checkout
        ```

- Never use CRUD function names in URIs

```
HTTP GET http://api.example.com/device-management/managed-devices  //Get all devices
HTTP POST http://api.example.com/device-management/managed-devices  //Create new Device
HTTP GET http://api.example.com/device-management/managed-devices/{id}  //Get device for given Id
HTTP PUT http://api.example.com/device-management/managed-devices/{id}  //Update device for given Id
HTTP DELETE http://api.example.com/device-management/managed-devices/{id}  //Delete device for given Id
```

- Use query component to filter URI collection

```
http://api.example.com/device-management/managed-devices
http://api.example.com/device-management/managed-devices?region=USA
http://api.example.com/device-management/managed-devices?region=USA&brand=XYZ
http://api.example.com/device-management/managed-devices?region=USA&brand=XYZ&sort=installation-date
```