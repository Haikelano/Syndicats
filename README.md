# Syndicats

Cree base de donées avec le nom : syndicats

modifier le fichier application.properties

# DataSource settings:
spring.datasource.url = jdbc:mysql://localhost:3306/syndicats
spring.datasource.username = root       :) mais votre username de base 
spring.datasource.password = Database   :) est le mot de passe 
spring.datasource.driverClassName = com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto = update
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy


# Importer votre projet 
quelque soit votre Ide le projet est fonctionne , importer l'ais

# Rest User 
 a Url : http://localhost:8080/users
# lister tous les utilisateur
http://localhost:8080/user

# Ajouter un user 
http://localhost:8080/user

exemple :) avec Advenced Rest Client 
{ "nom":"Haykel","prenom":"maaoui","email":"houka.maa@gmail.com", "tel":53652154 }



	

