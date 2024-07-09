db.restaurants.find()
db.restaurants.find({}, {'restaurant_id':1, 'name':1, 'borough':1, 'cuisine':1})
db.restaurants.find({}, {'_id':0, 'restaurant_id':1, 'name':1, 'borough':1, 'cuisine':1})
db.restaurants.find({}, {'_id':0, 'restaurant_id':1, 'name':1, 'borough':1, 'address.zipcode':1})
db.restaurants.find({'borough' : 'Bronx'})
db.restaurants.find({'borough': 'Bronx'}).limit(5)
db.restaurants.find({'borough': 'Bronx'}).skip(5).limit(5)
db.restaurants.find({'grades.score':{$gt:90}})
db.restaurants.find({$and:[{'grades.score':{$gt:80}}, {'grades.score':{$lt:100}}]})
db.restaurants.find({'address.coord.0':{$lt:-95.754168}})
db.restaurants.find({$and:[{'cuisine':{$ne:"American "}}, {'grades.score':{$gt:70}}, {'address.coord':{$lt:-65.754168}}]})
db.restaurants.find({$and:[{'cuisine':{$ne:"American "}}, {'grades.score':{$gt:70}}, {'address.coord':{$lt:-65.754168}}]})
db.restaurants.find({$and:[{'cuisine':{$ne:"American "}}, {'grades.grade':{$eq:'A'}}, {'borough':{$ne:"Brooklyn"}}]}).sort({'cuisine':-1})
db.restaurants.find({'name': /^Wil/}, {'_id':0,'restaurant_id':1, 'name':1, 'borough':1, 'cuisine':1})
db.restaurants.find({'name': /ces$/}, {'_id':0,'restaurant_id':1, 'name':1, 'borough':1, 'cuisine':1})
db.restaurants.find({'name': /Reg/}, {'_id':0,'restaurant_id':1, 'name':1, 'borough':1, 'cuisine':1})
db.restaurants.find({$and:[{'borough':'Bronx'}, {$or:[{'cuisine':"American "}, {'cuisine': "Chinese"}]}]})
db.restaurants.find({$or:[{'borough':'Staten Island'}, {'borough':"Queens"}, {'borough':"Bronx"}, {'borough':"Brooklyn"}]}, {'_id':0, 'restaurant_id':1, 'name':1, 'borough':1, 'cuisine':1})
db.restaurants.find({borough:{$nin:["Staten Island", "Queens", "Bronx", "Brooklyn"]}}, {'_id':0, 'restaurant_id':1, 'name':1, 'borough':1, 'cuisine':1})
db.restaurants.find({'grades.score':{$lte:10}}, {'_id':0, 'restaurant_id':1, 'name':1, 'borough':1, 'cuisine':1})
db.restaurants.find({$and:[{'name':{$not:/^Wil/}}, {'cuisine':"Seafood"}]}, {'_id':0,'restaurant_id':1, 'name':1, 'borough':1, 'cuisine':1})
db.restaurants.find({$and:[{'grades.grade': "A"}, {'grades.score': 11}, {'grades.date':{$eq:ISODate("2014-08-11T00:00:00Z")}}]}, {'_id':0,'restaurant_id':1, 'name':1, 'grades':1})
db.restaurants.find({$and:[{'grades.1.grade': "A"}, {'grades.1.score': 9}, {'grades.1.date':{$eq:ISODate("2014-08-11T00:00:00Z")}}]}, {'_id':0,'restaurant_id':1, 'name':1, 'grades':1})
db.restaurants.find({$and:[{'address.coord.1':{$gt:42}}, {'address.coord.1':{$lt:52}}]}, {'_id':0, 'restaurant_id':1, 'name':1, 'address':1, 'address.coord.0':1, 'address.coord.1':1})
db.restaurants.find().sort({name:1})
db.restaurants.find().sort({name:-1})
db.restaurants.find().sort({cuisine: 1, borough: -1})
db.restaurants.find({'address.street': null})
db.restaurants.find({'address.coord':{$type: 1}})
db.restaurants.find({'grades.score': {$mod:[7, 0]}}, {'_id':0,'restaurant_id':1, 'name':1, 'grades.score':1})
db.restaurants.find({'name': /mon/i}, {'_id':0, 'name':1, 'borough':1, 'address.coord.0':1, 'address.coord.1':1, 'cuisine': 1})
db.restaurants.find({'name': /^Mad/}, {'_id':0, 'name':1, 'borough':1, 'address.coord.0':1, 'address.coord.1':1, 'cuisine': 1})

