# InRhythmMerchandise-v2

### Summary

As an extra functionality this application has a simple UI. This UI lets you add pre-existing products into a shopping cart, increase and decrease the quantity while calculating your total balance. It also sorts products based on if it is electronic or a household item. It has been deployed on pcf dev.

### Endpoints

To access the UI, go to: 
http://inrhythmmerchandise-v2-balanced-dingo.local.pcfdev.io/product/index

The rest endpoints allow you to find by name, id, by electronics or list all products, as well as delete by id.

Rest Endpoints:

http://inrhythmmerchandise-v2-balanced-dingo.local.pcfdev.io/findAll
/findById/{id}                      - must be valid id num from list of products from /findAll
/findByName/{name}                  - must be valid name from list of products from /findAll
/findByIsElectronic/{isElectronic}  - must be boolean true or false
/deleteById/{id}                    - must be valid id num from list of products from /findAll
