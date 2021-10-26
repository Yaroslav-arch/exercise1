CREATE (:Actor{name:'Keanu Reeves'})-[:ACTED_IN]->(:Movie{name:'Matrix'})-[:IN_GENRE]->(:Genre{name:'Action'});
MATCH (m:Movie{name:'Matrix'})
CREATE (:Director{name:'Wachowski bros'})-[:DIRECTED]->(m)<-[:RATED]-(:User{nickname:'User123'});

CREATE (:Actor{name:'Mel Gibson'})-[:ACTED_IN]->(:Movie{name:'Mad Max'})-[:IN_GENRE]->(:Genre{name:'Action'});
MATCH (m:Movie{name:'Mad Max'})
CREATE (:Director{name:'George Miller'})-[:DIRECTED]->(m)<-[:RATED]-(:User{nickname:'User666'});

CREATE (:Actor{name:'Macaulay Culkin'})-[:ACTED_IN]->(:Movie{name:'Home Alone'})-[:IN_GENRE]->(:Genre{name:'Comedy'});
MATCH (m:Movie{name:'Home Alone'})
CREATE (:Director{name:'Chris Columbus'})-[:DIRECTED]->(m)<-[:RATED]-(:User{nickname:'User777'});

CREATE (:Actor{name:'Anthony Hopkins'})-[:ACTED_IN]->(:Movie{name:'The Silence of the Lambs'})-[:IN_GENRE]->(:Genre{name:'Horror'});
MATCH (m:Movie{name:'The Silence of the Lambs'})
CREATE (:Director{name:'Jonathan Demme'})-[:DIRECTED]->(m)<-[:RATED]-(:User{nickname:'User999'});

CREATE (:Actor{name:'Leonardo DiCaprio'})-[:ACTED_IN]->(:Movie{name:'Shutter Island'})-[:IN_GENRE]->(:Genre{name:'Detective'});
MATCH (m:Movie{name:'Shutter Island'})
CREATE (:Director{name:'Martin Scorsese'})-[:DIRECTED]->(m)<-[:RATED]-(:User{nickname:'User555'});