import json
__package__

def sorted_notes(data):
    keys = []
    for i in data["Notes"].keys():
        keys.append(int(i))
    keys = sorted(keys)  
    sort_dic = {
    }
    for i in keys:
        for j in data["Notes"].keys():
            if i == int(j):
                tmp = {j:data["Notes"][j]}
                sort_dic.update(tmp)
    data = {
            "Notes": sort_dic
        }
    return data


def get_all_notes():
    with open("data_file.json", "r") as read_file:
        try:
            data = json.load(read_file)
            return data
        except:
            data = ""
            return data


def add_note(note):
    data = get_all_notes()
    tmp = {
        f"{note.ID}": {
            "head": f"{note.head}",
            "body": f"{note.body}",
                    "date": f"{note.date}",
                    "time": f"{note.time}"
        }
    }
    if len(data) > 0:
        (data["Notes"]).update(tmp)
        data = sorted_notes(data)
    else:
        data = {
            "Notes": tmp
        }
    
    
    with open("data_file.json", "w") as write_file:
        json.dump(data, write_file, indent=4)


def dell_note(id):
    data = get_all_notes()
    data["Notes"].pop(f"{id}")
    with open("data_file.json", "w") as write_file:
        json.dump(data, write_file, indent=4)


def update_note(note):
    data = get_all_notes()
    tmp = {
        f"{note.ID}": {
            "head": f"{note.head}",
            "body": f"{note.body}",
                    "date": f"{note.date}",
                    "time": f"{note.time}"
        }
    }
    if len(data) > 0:
        (data["Notes"]).update(tmp)
    else:
        data = {
            "Notes": tmp
        }
    with open("data_file.json", "w") as write_file:
        json.dump(data, write_file, sort_keys=True, indent=4)
