import re
import json; 
from selenium import webdriver
from time import sleep
from selenium.webdriver.chrome.options import Options


def search_flower(flower):

	driver.get("https://garden.org/plants/search/text/?q=" + flower);
	sleep(2);
	table = driver.find_element_by_class_name('pretty-table');
	links = table.find_elements_by_tag_name('a');
	links[1].click();
	

def parse_flower_properties():

	sun = "";
	water = "";
	min_temp = "";
	max_temp = "";

	tables = driver.find_elements_by_class_name('simple-table');

	for table in tables: 

		flower_properties = table.find_elements_by_tag_name('td');

		for index in range (0, len(flower_properties)):

			if flower_properties[index].text == 'Sun Requirements:':
				sun = flower_properties[index + 1].text.split("\n")[0];

			if flower_properties[index].text == 'Water Preferences:':
				water = flower_properties[index + 1].text.split("\n")[0]; 


			if flower_properties[index].text == 'Minimum cold hardiness:':
				min_temp = flower_properties[index + 1].text.split("\n")[0];

			if flower_properties[index].text == 'Maximum recommended zone:':
				max_temp = flower_properties[index + 1].text.split("\n")[0];



	if sun == "":
		sun = 'Full Sun';

	if water == "":
		water = 'Mesic';

	if min_temp == "":
		min_temp = "Zone 5b -26.1 C (-15 F) to -23.3 C (-10 F)";

	if max_temp == "":
		max_temp = "Zone 6b";

	flower_obj = create_flower_dict(sun, water, min_temp, max_temp);
	return flower_obj;

def create_flower_dict(sun, water, min_temp, max_temp):

	return {'sun': sun, 'water' : water, 'min_temp' : min_temp, 'max_temp': max_temp};


options = Options() 
options.add_argument("--start-maximized") 
driver= webdriver.Chrome(chrome_options=options) 

flowers_names = ['Periwinkle', 'Petunia', 'Orchid', 'Lavender', 'Daisy', 'Carnation', 'Chrysanthemum', 'Primrose', 'Snowdrop', 'Violet', 'Rose', 'Lily', 'Hydrangea', 'Hibiscus', 'Daffodil', 
'Tulip', 'Sunflower', 'Iris', 'Fuchsia', 'Narcissus', 'Lilac', 'Bellflower'];

flowers = {};

for name in flowers_names:
	search_flower(name);
	sleep(2);
	flowers[name] = parse_flower_properties();


with open('flowers.json', 'w') as outfile:
    json.dump(flowers, outfile);


