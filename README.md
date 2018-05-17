# InRhythmMerchandise-v2

### Summary

As an extra functionality this application has a simple UI. This UI lets you add pre-existing products into a shopping cart, increase and decrease the quantity while calculating your total balance. It also sorts products based on if it is electronic or a household item. It has been deployed on pcf dev.

### Endpoints

To access the UI, go to: 
/product/index

The rest endpoints allow you to find by name, id, by electronics or list all products, as well as delete by id.

Rest Endpoints:

/findAll                            - get all products <br />
/findById/{id}                      - must be id from products from /findAll <br />
/findByName/{name}                  - must be name from products from /findAll <br />
/findByIsElectronic/{isElectronic}  - must be true/false <br />
/deleteById/{id}                    - must be id from products from /findAll <br />
