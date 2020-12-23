import styled from 'styled-components';
import { shade } from 'polished';

export const Container = styled.button`
  background: #00d3fb;
  height: 56px;
  border-radius: 10px;
  border: 0;
  padding: 0 16px;
  color: #fff;
  width: 50%;
  font-weight: 500;
  margin: 16px auto 0;
  transition: background-color 0.2s;
  font-weight: bold;
  font-size: 18px;

  &:hover {
    background: ${shade(0.2, '#00d3fb')};
  }
`;
