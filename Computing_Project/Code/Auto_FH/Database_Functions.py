import sqlalchemy as db
from sqlalchemy import create_engine

engine = create_engine('sqlite:///C:/Users/natha/Desktop/GitRepo/NathanLamplough/Computing_Project/Code/Database/AutoFH.db')
connection = engine.connect()
metadata = db.MetaData()
test = db.Table('test', metadata, autoload=True, autoload_with=engine)
te = connection.execute(db.select([test])).fetchall()

print(te)