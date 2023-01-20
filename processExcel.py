
# import module
import openpyxl
  
# load excel with its path
wrkbk = openpyxl.load_workbook("Book1.xlsx")
  
listDataCourse = []
sh = wrkbk.active
  
# iterate through excel and display data
for col in sh.iter_cols(min_row=1, min_col=2, max_row=7, max_col=28):
    for cell in col:
        listDataCourse.append(cell.value)
    
print(listDataCourse)


with open('readme.txt', 'w') as f:
    for line in listDataCourse:
        f.write(str(line))
        f.write('\n')