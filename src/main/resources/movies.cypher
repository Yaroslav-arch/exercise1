CREATE (a:Actor {name: 'Keanu Reeves'})-[:ACTED_IN]->(m:Movie {name: 'Matrix'})-[:IN_GENRE]->(:Genre {name: 'Action'}),
       (:Director {name: 'Wachowski bros'})-[:DIRECTED]->(m)<-[:RATED]-(:User {nickname: 'User123'}),
       (:Actor {name:'Hugo Weaving'})-[ACTED_IN]->(m), (a:Actor)-[ACTED_IN]->(:Movie{name:'JohnWick'});

CREATE (:Actor {name: 'Mel Gibson'})-[:ACTED_IN]->(m:Movie {name: 'Mad Max'})-[:IN_GENRE]->(:Genre {name: 'Action'}),
       (:Director {name: 'George Miller'})-[:DIRECTED]->(m)<-[:RATED]-(:User {nickname: 'User666'});

CREATE (:Actor {name: 'Macaulay Culkin'})-[:ACTED_IN]->(m:Movie {name: 'Home Alone'})
         -[:IN_GENRE]->(:Genre {name: 'Comedy'}),
       (:Director {name: 'Chris Columbus'})-[:DIRECTED]->(m)<-[:RATED]-(:User {nickname: 'User777'});

CREATE (:Actor {name: 'Anthony Hopkins'})-[:ACTED_IN]->(m:Movie {name: 'The Silence of the Lambs'})
            -[:IN_GENRE]->(:Genre {name: 'Horror'}),
          (:Director {name: 'Jonathan Demme'})-[:DIRECTED]->(m)<-[:RATED]-(:User {nickname: 'User999'});

CREATE (:Actor {name: 'Leonardo DiCaprio'})-[:ACTED_IN]->(m:Movie {name: 'Shutter Island'})
        -[:IN_GENRE]->(:Genre {name: 'Detective'}),
      (:Director {name: 'Martin Scorsese'})-[:DIRECTED]->(m)<-[:RATED]-(:User {nickname: 'User555'});