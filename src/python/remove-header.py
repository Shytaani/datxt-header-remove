import pandas as pd

data_path='../../data'

with open(f'{data_path}/test.dat', 'r') as f:
    df_no_header = pd.DataFrame(pd.read_csv(f, header=1, index_col=0))
    print(df_no_header)

with open(f'{data_path}/test_no_header.csv', 'w') as f:
    df_no_header.to_csv(f)